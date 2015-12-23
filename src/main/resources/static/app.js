import React from 'react'
import ReactDOM from 'react-dom'
import {Router, Route, Link} from 'react-router'
import ProductList from './products'
import Cart from './cart'

class Main extends React.Component {
    constructor(props){
        let products = [];

        super(props);

        this.state = {
            name: "Harry"
        };
    }
    render(){
        return(
            <Storefront name={this.state.name} />
        );
    }
}

var a = 10;


let Storefront = (props) =>
<div className="container">
    <h4>Welcome to the React Store Front, {props.name}!</h4>
    <h3>uaua</h3>
    <Link to="/products">View Products</Link><br/>
    <Link to="/cart">Cart</Link><br/>
    <Link to="/login">Login</Link>
</div>;

class Login extends React.Component{

    constructor(props){
        super(props);

        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(e){
        e.preventDefault();
        console.log("submitted");
    }

    render(){
        return(
            <div className="container">
                <form action="/login">
                    <label htmlFor="username">Username</label>
                    <input type="text" name="username" id="username"/><br/>
                    <label htmlFor="password">Password</label>
                    <input type="text" name="password" id="password"/>
                    <button onClick={this.handleSubmit}>Login</button>
                </form>
            </div>
        );
    }
}

ReactDOM.render(
    <Router>
        <Route path="/" component={Main}/>
        <Route path="/products" component={ProductList}/>
        <Route path="/login" component={Login}/>
        <Route path="/cart" component={Cart}/>
    </Router>,
    document.getElementById("app")
);