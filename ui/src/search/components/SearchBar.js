import React, { useState } from 'react';
import searchIcon from './searchIcon.png';
import findWines from '../findWines';
import { SearchResult } from './SearchResult';

export default function SearchBar() {
    const [results, setResults] = useState([]);

    async function autoComplete({ target }) {
        const query = target.value;
        setResults(query ? await findWines(query) : []);
    }

    return (
        <div className="SearchBar">
            <div className="SearchBarInputContainer">
                <img src={searchIcon} className="SearchIcon" alt="icon" />
                <input autoFocus type="text" onChange={autoComplete} className="SearchInput" placeholder="Search by lot code and description......" />
            </div>
            <div>
                {results.map((wine) => <SearchResult key={wine.lotCode} result={wine} />)}
            </div>
        </div>
    );
}
