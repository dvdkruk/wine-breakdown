import React from 'react';

export function BreakdownSelector({ options, onSelection, select }) {
    return (
        <div className="BreakdownSelector">
            {options.map(option => {
                return <a href={`#${option.key}`}
                    className={`BreakdownOption ${option.key === select.key ? 'active' : ''}`}
                    key={option.key}
                    onClick={() => onSelection(option)}>
                    {option.displayName}
                </a>;
            })}
        </div>
    );
}
