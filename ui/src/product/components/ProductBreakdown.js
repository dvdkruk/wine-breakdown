import React, { useState, useEffect } from 'react';
import fetchBreakdown from '../fetchBreakdown'

export default function ProductBreakdown({ lotCode }) {
    const breakdownOptions = [
        { key: "year", displayName: "Year" },
        { key: "variety", displayName: "Variety" },
        { key: "region", displayName: "Region" },
        { key: "year-variety", displayName: "Year & Variety" },
    ]
    const [breakdownType, setbreakdownType] = useState(breakdownOptions[0]);
    const [breakdown, setBreakdown] = useState([]);

    useEffect(() => {
        fetchBreakdown(lotCode, breakdownType.key)
            .then(({ breakdown }) => setBreakdown(breakdown))
    }, [breakdownType.key, lotCode])

    return (
        <div>
            <BreakdownSelector options={breakdownOptions} onSelection={setbreakdownType} select={breakdownType} />
            <BreakdownTable displayType={breakdownType.displayName} breakdown={breakdown} />
        </div>
    );
}

function BreakdownTable({ displayType, breakdown }) {
    const [elements, setElements] = useState([]);
    const [displayLimit, setDisplayLimit] = useState(5);
    const showMoreActive = displayLimit < elements.length;

    if (elements !== breakdown) {
        setElements(breakdown);
        setDisplayLimit(5);
    }

    function showMore() {
        setDisplayLimit(displayLimit + 5)
    }

    return <table className="BreakdownTable">
        <thead>
            <tr>
                <th>{displayType}</th>
                <th>Percentage</th>
            </tr>
        </thead>
        <tbody>
            {elements.slice(0, displayLimit).map(element => <BreakdownElement key={element.key} element={element} />)}
            {showMoreActive ?
                <tr className="ShowMoreButtonRow">
                    <td colSpan="2">
                        <button onClick={showMore} className="ShowMoreButton">Show more <i className="material-icons">expand_more</i></button>
                    </td>
                </tr>
                : ""}
        </tbody>
    </table>;
}

function BreakdownElement({ element }) {
    return <tr><td>{element.key}</td><td>{element.percentage}%</td></tr>;
}

function BreakdownSelector({ options, onSelection, select }) {
    return (
        <div className="BreakdownSelector">
            {options.map(option => {
                return <a href={`#${option.key}`}
                    className={`BreakdownOption ${option.key === select.key ? 'active' : ''}`}
                    key={option.key}
                    onClick={() => onSelection(option)}>
                    {option.displayName}
                </a>
            })}
        </div>
    );
}

