import './App.css';
import icon from './ICON.png';
import searchIcon from './searchIcon.png';

function Search() {
  return (
    <div className="Search-frame">
      <img src={searchIcon} className="Search-icon" alt="icon"/>
      <input type="text" />
    </div>
  )
}

function WineSearch() {
  return (
    <div className="WineSearch-frame">
      <div className="WineSearch-header-frame">
        <header className="WineSearch-header">Wine search</header> 
        <div className="WineSearch-icon-box">
          <img src={icon} className="WineSearch-icon" alt="icon"/>
        </div>
      </div>
      <Search/>
    </div>
    
  )
}

function App() {
  return (
    <WineSearch/>
  );
}

export default App;
