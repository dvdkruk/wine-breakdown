import WineSearchPage from './search/WineSearchPage'
import ProductDetailsPage from './product/ProductDetailsPage'
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <Router>
        <Switch>
          <Route path="/product/:lotCode"><ProductDetailsPage /></Route>
          <Route path="/"><WineSearchPage /></Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
