import React, { useState, useEffect } from 'react';
import fetchBreakdown from './fetchBreakdown'

export default function ProductBreakdown({ lotCode }) {
    const breakdownOptions = [
        { key: "year", displayName: "Year" },
        { key: "variety", displayName: "Variety" },
        { key: "region", displayName: "Region" },
        { key: "year-variety", displayName: "Year & Variety" },
    ]
    const [breakdownType, setbreakdownType] = useState("year");
    const [breakdown, setbreakdown] = useState([]);



    useEffect(() => {
        fetchBreakdown(lotCode, breakdownType)
            .then(breakdown => setbreakdown(breakdown.breakdown))
    }, [])

    console.log(breakdown)

    return (
        <div>
            <BreakdownSelector options={breakdownOptions} onSelection={setbreakdownType} />
            <table>
                <thead>
                    <tr>
                        <th>Year</th>
                        <th>Percentage</th>
                    </tr>
                </thead>
                <tbody>
                    {breakdown.map(e => {
                        return <tr key={e.key}><td>{e.key}</td><td>{e.percentage}</td></tr>
                    })}
                </tbody>
            </table>
        </div>
    );
}
function BreakdownSelector({ options, onSelection }) {
    return <div>
        {options.map(option => {
            return <div key={option.key} onClick={() => onSelection(option.key)}>{option.displayName}</div>;
        })}
    </div>;
}

