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
        fetch("/addcartitem?customerId=1111", {
            method: 'post',
            body: JSON.stringify(product)
        });
        console.log("Added item to cart");
        console.log(product);
    }

    render()
    {
        let productsList = this.state.prods.map( (product) =>{
            let boundAddItem = this.addItemToCart.bind(this, product);

            return(
                <Product key={product.productId} product={product} func={boundAddItem}/>
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
        <td><input type="button" value="Add Item" onClick={props.func}/></td>
    </tr>;

export default ProductList
