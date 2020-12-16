import './ProductViewPage.css'
import Icon from './Icon.png'
import { useParams, useHistory } from "react-router-dom";
import ProductBreakdown from './ProductBreakdown';

export default function ProductViewPage() {
    const { lotCode } = useParams();
    const history = useHistory();

    return (
        <div className="ProductViewPage-frame">
            <div className="ProductViewHeader-frame">
                <div>
                    <div onClick={() => history.push("/")}><i className="material-icons">arrow_back</i></div>
                    <div>
                        <img src={Icon} className="ProductViewHeader-icon left" alt="Product icon" />
                        <h2>{lotCode}</h2>
                    </div>
                    <div>description</div>
                </div>
                <div className="right">
                    edit
                </div>
            </div>
            <ProductBreakdown lotCode={lotCode} />
        </div>
    );
}

