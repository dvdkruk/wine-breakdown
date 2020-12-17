import React, { useState } from 'react';

export function BreakdownTable({ displayType, breakdown }) {
    const [elements, setElements] = useState([]);
    const [displayLimit, setDisplayLimit] = useState(5);
    const showMoreActive = displayLimit < elements.length;

    if (elements !== breakdown) {
        setElements(breakdown);
        setDisplayLimit(5);
    }

    function showMore() {
        setDisplayLimit(displayLimit + 5);
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

export function BreakdownElement({ element }) {
    return <tr><td>{element.key}</td><td>{element.percentage}%</td></tr>;
}
