import React, { useState } from 'react';
import icon from './ICON.png';
import searchIcon from './searchIcon.png';

function SearchBar() {
  const [results, setResults] = useState([])

  function autoComplete(event) {
    const query = event.target.value;
    if(query) {
      fetch(`api/wines?search=${query}`)
      .then(res => res.json())
      .then(
        (result) => setResults(result.wines),
        (error) => console.error(error)
      )
    } else {
      setResults([])
    }
  }

  function SearchResult(props) {
    const wine = props.result

    return ( 
      <div>
        <div>
          {wine.lotCode}
          <div>{wine.volume}</div>
        </div>
        <div>
          {wine.desciption}
          {wine.tankCode}
        </div>
      </div>);
  }

  function searchResults() {
    return results.map((wine) => <SearchResult key={wine.lotCode} result={wine}/>);
  }

  return (
    <div>
      <div className="Search-frame">
        <img src={searchIcon} className="Search-icon" alt="icon"/>
        <input type="text" onChange={autoComplete} />
      </div>
      {searchResults()}
    </div>
  )
}

export default function WineSearch() {
  return (
    <div className="WineSearch-frame">
      <div className="WineSearch-header-frame">
        <header className="WineSearch-header">Wine search</header> 
        <div className="WineSearch-icon-box">
          <img src={icon} className="WineSearch-icon" alt="icon"/>
        </div>
      </div>
      <SearchBar/>
    </div>
  )
}
