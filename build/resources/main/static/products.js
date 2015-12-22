import React from 'react'

class ProductList extends React.Component
{
    constructor(props){
        super(props);

        this.state = {
            prods: []
        }
    }

    componentWillMount(){
        let prods = [];

        fetch("/getproducts")
            .then(r=>r.json())
            .then(data =>{
                this.setState({prods: data});
            })
            .catch("Something went wrong :sad:");
    }

    render()
    {
        let productsList = this.state.prods.map( (product) =>{
            return(
                <tr key={product.productId}>
                    <td><img src={product.productPath} alt=""/></td>
                    <td>{product.productName}</td>
                    <td>{product.quantity}</td>
                    <td>{product.unitPrice}</td>
                </tr>
            )
        });

        return(
            <div className="container">
                <a href="/">Home</a>
                <table className="table table-bordered">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Name</th>
                        <th>Qty Available</th>
                        <th>Unit Price</th>
                    </tr>
                    </thead>
                    <tbody>{productsList}</tbody>
                </table>
            </div>
        )
    }
}

export default ProductList
