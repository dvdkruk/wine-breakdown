import React, { useState, useEffect } from 'react';
import fetchBreakdown from './fetchBreakdown'

export default function ProductBreakdown({ lotCode }) {
    const breakdownOptions = [
        { key: "year", displayName: "Year" },
        { key: "variety", displayName: "Variety" },
        { key: "region", displayName: "Region" },
        { key: "year-variety", displayName: "Year & Variety" },
    ]
    const [breakdownType, setbreakdownType] = useState(breakdownOptions[0]);
    const [breakdown, setbreakdown] = useState([]);

    useEffect(() => {
        fetchBreakdown(lotCode, breakdownType.key)
            .then(({ breakdown }) => setbreakdown(breakdown))
    }, [breakdownType.key, lotCode])

    const breakdownElemtents = breakdown.map(e => <tr key={e.key}><td>{e.key}</td><td>{e.percentage}</td></tr>);
    return (
        <div>
            <BreakdownSelector options={breakdownOptions} onSelection={setbreakdownType} select={breakdownType} />
            <table>
                <thead>
                    <tr>
                        <th>{breakdownType.displayName}</th>
                        <th>Percentage</th>
                    </tr>
                </thead>
                <tbody>
                    {breakdownElemtents}
                </tbody>
            </table>
        </div>
    );
}

function BreakdownSelector({ options, onSelection, select }) {
    return (
        <div className="BreakdownSelector">
            {options.map(option => {
                return <div
                    className={`BreakdownOption ${option.key === select.key ? 'active' : ''}`}
                    key={option.key}
                    onClick={() => onSelection(option)}>
                    {option.displayName}
                </div>
            })}
        </div>
    );
}

