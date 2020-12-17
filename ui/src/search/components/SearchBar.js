import React, { useState } from 'react';
import searchIcon from './searchIcon.png';
import findWines from '../findWines';
import { SearchResult } from './SearchResult';
import { useHistory } from "react-router-dom";

export default function SearchBar() {
    const history = useHistory();
    const [results, setResults] = useState([]);
    const [query, setQuery] = useState('')

    async function autoComplete({ target }) {
        const query = target.value;
        setQuery(query)
        setResults(query ? await findWines(query) : []);
    }

    function openProductDetails(wine) {
        history.push(`/product/${wine.lotCode}`);        
    }

    function handleKeyDown(event) {
        if (event.key === 'Enter') {
            if (results.length > 0) {
                openProductDetails(results[0])
            }
        }
    }

    return (
        <div className="SearchBar">
            <div className="SearchBarInputContainer">
                <img src={searchIcon} className="SearchIcon" alt="icon" />
                <input
                    autoFocus
                    type="text"
                    onChange={autoComplete}
                    className="SearchInput"
                    placeholder="Search by lot code and description......"
                    onKeyDown={handleKeyDown}
                />
            </div>
            <div>
                {results.map((wine) => <SearchResult key={wine.lotCode} result={wine} highlight={query} onSelect={openProductDetails} />)}
            </div>
        </div>
    );
}
