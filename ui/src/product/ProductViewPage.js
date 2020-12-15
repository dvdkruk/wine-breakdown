import './ProductViewPage.css'
import Icon from './Icon.png'
import { useParams, useHistory } from "react-router-dom";

export default function ProductViewPage() {
    const { lotCode } = useParams();
    const history = useHistory();

    return (
      <div className="ProductViewPage-frame">
        <div className="ProductViewHeader-frame">
            <div className="left">
                <div onClick={history.goBack}><i class="material-icons">arrow_back</i></div>
                <div>
                    <div className="left"><img src={Icon} className="ProductViewHeader-icon" alt="Product icon"/></div>
                    <h2>{lotCode}</h2>
                </div>
                <div>description</div>
            </div>
            <div className="right">
                edit
            </div>
        </div>
      </div>
    );
  }