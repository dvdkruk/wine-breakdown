import React, { useState } from 'react';
import searchIcon from './searchIcon.png';
import findWines from './findWines';
import { useHistory } from "react-router-dom";

export default function SearchBar() {
  const [results, setResults] = useState([]);

  async function autoComplete({ target }) {
    const query = target.value;
    setResults(query ? await findWines(query) : []);
  }

  return (
    <div className="SearchBar-frame">
      <div className="SearchInput-frame">
        <div className="SearchInput-left">
          <img src={searchIcon} className="Search-icon left" alt="icon" />
          <input type="text" onChange={autoComplete} className="SearchInput-input" placeholder="Search by lot code and description......" />
        </div>
        
      </div>
        <SearchResults results={results} />
    </div>
  );
}

function SearchResult({result: wine}) {
  const history = useHistory();

  function click() {
    history.push(`/product/${wine.lotCode}`)
  }

  return (
    <div className="SearchResult SearchResult-divider" onClick={click}>
      <div className="left">
        <div className="SearchResult-primary">{wine.lotCode}</div>
        <div className="SearchResult-secondary">{wine.description}</div>
      </div>
      <div className="right">
        <div className="SearchResult-secondary">{wine.volume}</div>
        <div className="SearchResult-secondary">{wine.tankCode}</div>
      </div>
    </div>);
}

function SearchResults({ results }) {
  return <div>
    {results.map((wine) => <SearchResult key={wine.lotCode} result={wine} />)}
  </div>;
}

