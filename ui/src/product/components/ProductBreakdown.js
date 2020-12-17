import React, { useState, useEffect } from 'react';
import fetchBreakdown from '../fetchBreakdown'
import { BreakdownSelector } from './BreakdownSelector';
import { BreakdownTable } from './BreakdownTable';

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
