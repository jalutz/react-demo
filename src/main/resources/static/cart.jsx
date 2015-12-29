import React from 'react'

class Cart extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            prods: []
        }
    }

    componentWillMount(){
        let prods = [];

        fetch("/getcartitems?customerId=3")
            .then(r=>r.json())
            .then(data =>{
                this.setState({prods: data});
            })
            .catch("Something went wrong :sad:");
    }


    render(){
        let productList = this.state.prods.map((cartDetail) =>{
            let totalPrice = cartDetail.productPrice * cartDetail.quantity;

            return(
                <CartItem key={cartDetail.productId} totalPrice={totalPrice} cartDetail={cartDetail}/>
            )
        });

        return(
            <div className="container">
                <a href="/">Home</a>
                <div>This is the cart</div>
                <table className="table table-bordered">
                    <tbody>
                        <tr>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                        </tr>
                        {productList}
                    </tbody>
                </table>
            </div>
        )
    }
}

class CartItem extends React.Component{
    constructor(props){
        super(props)

        this.state = {
            cartDetail: props.cartDetail
        }
    }

    updateCartDetail(cartDetail){
        console.log(cartDetail);
        var newQty = this.refs.newQty.getDOMNode().value;
        console.log(this.refs.newQty.getDOMNode().value);
        cartDetail.quantity = newQty;

        console.log(cartDetail);

        fetch('/updatecartitem', {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            method: 'put',
            body: cartDetail
        }).then(r=>r.json())
            .then(data=>{
                console.log("updated cart item")
            })
            .catch(console.log("didnt work"));

        //console.log(this.state.cartDetail);
        //
        //this.setState({
        //    cartDetail: this.state.cartDetail
        //});
        //
        //console.log(item);
        //
        //let cartDetail = JSON.stringify(item);
        //
        //console.log(cartDetail);
        //
        //fetch('/updatecartitem', {
        //    headers: {
        //        'Accept': 'application/json',
        //        'Content-Type': 'application/json'
        //    },
        //    method: 'put',
        //    body: cartDetail
        //}).then(r=>r.json())
        //    .then(data=>{
        //        console.log("updated cart item")
        //    })
        //    .catch(console.log("didnt work"));
    }

    handleChange(event){
        console.log(event.target.value);
        let newCartDetail = cartDetail;
        newCartDetail.quantity = event.target.value;
        console.log(newCartDetail);
    }

    render(){
        return(
            <tr>
                <td>{this.props.cartDetail.productName}</td>
                <td>
                    <input type="number" ref="newQty" defaultValue={this.props.cartDetail.quantity}/>
                    <button onClick={this.updateCartDetail.bind(this, this.props.cartDetail)}>Update Item</button>
                </td>
                <td>{this.props.totalPrice}</td>
            </tr>
        )
    }

}

export default Cart