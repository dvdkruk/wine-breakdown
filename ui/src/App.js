import './App.css';
import WineSearchPage from './search/WineSearchPage'
import ProductViewPage from './product/ProductViewPage'
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <Router>
        <Switch>
          <Route path="/product/:lotCode"><ProductViewPage /></Route>
          <Route path="/"><WineSearchPage /></Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
