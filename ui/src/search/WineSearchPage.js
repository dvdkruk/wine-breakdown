import React from 'react';
import icon from './components/ICON.png';
import SearchBar from './components/SearchBar';
import './search.css'

export default function WineSearchPage() {
  return (
    <div className="WineSearchPage">
      <div className="WineSearchHeader">
        <header className="HeaderTitle">Wine search</header> 
        <div className="HeaderIconContainer">
          <img src={icon} className="HeaderIcon" alt="icon"/>
        </div>
      </div>
      <SearchBar/>
    </div>
  )
}
 