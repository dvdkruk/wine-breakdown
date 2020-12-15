import React from 'react';
import icon from './ICON.png';
import SearchBar from './SearchBar';

export default function WineSearchPage() {
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
