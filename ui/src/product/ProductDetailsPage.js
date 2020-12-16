import './product.css'
import Icon from './components/Icon.png'
import { useParams, useHistory } from "react-router-dom";
import React, { useState, useEffect } from 'react';
import ProductBreakdown from './components/ProductBreakdown';
import fetchWine from './fetchWine';

export default function ProductDetailsPage() {
    const { lotCode } = useParams();
    const history = useHistory();
    const [product, setProduct] = useState({});

    useEffect(() => {
        fetchWine(lotCode).then(setProduct)
    }, [lotCode])

    return (
        <div className="ProductDetailsPage">
            <div className="ProductDetailsHeader">
                <div>
                    <BackButton onClick={() => history.push("/")} />
                    <div>
                        <img src={Icon} className="ProductIcon left" alt="Product icon" />
                        <h2>{lotCode}</h2>
                    </div>
                    <p>{product.description}</p>
                </div>
            </div>
            <table className="ProductDetails">
                <tbody>
                    <tr>
                        <td>Volume</td>
                        <td className="ProductDetails-value">{product.volume} L</td>
                    </tr>
                    <tr>
                        <td>Tank code</td>
                        <td className="ProductDetails-value">{product.tankCode}</td>
                    </tr>
                    <tr>
                        <td>Product state</td>
                        <td className="ProductDetails-value">{product.productState}</td>
                    </tr>
                    <tr>
                        <td>Owner</td>
                        <td className="ProductDetails-value">{product.ownerName}</td>
                    </tr>
                </tbody>
            </table>
            <ProductBreakdown lotCode={lotCode} />
        </div>
    );
}

function BackButton({ onClick }) {
    return <a href="#back" className="BackButton material-icons" onClick={onClick}>arrow_back</a>;
}

