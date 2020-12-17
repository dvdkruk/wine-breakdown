import React from 'react';
import { useHistory } from "react-router-dom";

export function SearchResult({ result: wine }) {
    const history = useHistory();

    function click() {
        history.push(`/product/${wine.lotCode}`);
    }

    return (
        <div className="SearchResult" onClick={click}>
            <div className="left">
                <div className="primary">{wine.lotCode}</div>
                <div className="secondary">{wine.description}</div>
            </div>
            <div className="right">
                <div className="secondary">{wine.volume}</div>
                <div className="secondary">{wine.tankCode}</div>
            </div>
        </div>);
}
