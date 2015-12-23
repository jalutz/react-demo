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

    addItemToCart(product){
        console.log("Added item to cart");
        console.log(product);
    }

    render()
    {

        let productsList = this.state.prods.map( (product) =>{
            let addToCart = this.addItemToCart(product).bind(this);

            return(
                <Product key={product.productId} product={product}/>
            )
        });

        return(
            <div className="container">
                <a href="/">Home</a>
                <h4>Products List</h4>
                <table className="table table-bordered">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Name</th>
                        <th>Qty Available</th>
                        <th>Unit Price</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>{productsList}</tbody>
                </table>
            </div>
        )
    }
}

let Product = (props) =>
    <tr>
        <td><img height="107" width="113" src={props.product.productPath} alt=""/></td>
        <td>{props.product.productName}</td>
        <td>{props.product.quantity}</td>
        <td>{props.product.unitPrice}</td>
        <td><input type="button" value="Add Item"/></td>
    </tr>;

export default ProductList
