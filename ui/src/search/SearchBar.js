import React, { useState } from 'react';
import searchIcon from './searchIcon.png';
import findWines from './findWines';

export default function SearchBar() {
  const [results, setResults] = useState([]);

  async function autoComplete({ target }) {
    const query = target.value;
    setResults(query ? await findWines(query) : []);
  }

  return (
    <div className="SearchBar-frame">
      <div className="SearchInput-frame">
        <img src={searchIcon} className="Search-icon" alt="icon" />
        <input type="text" onChange={autoComplete} />
      </div>
        <SearchResults results={results} />
    </div>
  );
}

function SearchResult({result: wine}) {
  return (
    <div className="SearchResult SearchResult-divider">
      <div className="left">
        <div className="SearchResult-primary">{wine.lotCode}</div>
        <div className="SearchResult-secondary">{wine.volume}</div>
      </div>
      <div className="right">
        <div className="SearchResult-secondary">{wine.desciption}</div>
        <div className="SearchResult-secondary">{wine.tankCode}</div>
      </div>
    </div>);
}

function SearchResults({ results }) {
  return <div>
    {results.map((wine) => <SearchResult key={wine.lotCode} result={wine} />)}
  </div>;
}

