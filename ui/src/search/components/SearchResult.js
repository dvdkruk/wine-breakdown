import React from 'react';
import Highlighter from "react-highlight-words";

export function SearchResult({ result: wine, highlight, onSelect }) {
    return (
        <div className="SearchResult" onClick={() => onSelect(wine)}>
            <div className="left">
                <div className="primary">
                    <Highlighter textToHighlight={wine.lotCode} searchWords={[highlight]} />
                </div>
                <div className="secondary">
                    <Highlighter textToHighlight={wine.description} searchWords={[highlight]} />
                </div>
            </div>
            <div className="right">
                <div className="secondary">{wine.volume}</div>
                <div className="secondary">{wine.tankCode}</div>
            </div>
        </div>);
}
