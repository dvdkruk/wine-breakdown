import React from 'react';

export function BackButton({ onClick }) {
    return <button className="BackButton" onClick={onClick}><i className="material-icons">arrow_back</i></button>;
}
