import React from 'react'

class Cart extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            prods: []
        }
    }

    render(){
        let productList = this.state.prods.map((product) =>{
            return(
                <CartItem key={product.productId} product={product}/>
            )
        });

        return(
            <div className="container">
                <a href="/">Home</a>
                <div>This is the cart</div>
                <table className="table table-bordered">
                    <tr>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                    {productList}
                </table>
            </div>
        )
    }
}

let CartItem = (props) =>
    <tr>
        <td>props.product.productName</td>
        <td>props.product.quantity</td>
        <td>props.product.unitPrice</td>
    </tr>;

export default Cart