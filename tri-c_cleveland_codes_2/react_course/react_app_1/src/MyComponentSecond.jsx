import { useState } from "react";

export function MyComponentSecond() {
    const [name, setName] = useState("Guest");

    const [quantity, setQuantity] = useState(1);

    const [comment, setComment] = useState("");
    
    const [payment, setPayment] = useState("");

    const [shipping, setShipping] = useState("Delivery");

    function handleNameChange(e) {
        setName(e.target.value)
    }

    function handleQuantityChange (e) {
        setQuantity(e.target.value);
    }

    function handleCommentChange (e) {
        setComment(e.target.value);
    }

    function handlePaymentChange (e) {
        setPayment(e.target.value);
    }

    function handleShippingChange (e) {
        setShipping(e.target.value);
    }

    return(
        <div>
            <input type="text" value={name} onChange={(e) => handleNameChange(e)}/>
            <p>Name: {name}</p>

            <input type="number" value={quantity} onChange={handleQuantityChange}/>
            <p>Quantity: {quantity}</p>

            <textarea name="" id="" value={comment} onChange={handleCommentChange} placeholder="Delivery Instructions"></textarea>
            <p>Comment: {comment}</p>

            <select value={payment} onChange={handlePaymentChange} name="" id="">
                <option value="">Select an Option</option>
                <option value="Visa">Visa</option>
                <option value="Mastercard">Mastercard</option>
                <option value="Giftcard">Giftcard</option>
            </select>
            <p>Payment: {payment}</p>
            <br />
            <label htmlFor="">
                <input type="radio" name="" id="" value="Pick Up" 
                    checked={shipping === "Pick Up"}
                    onChange={handleShippingChange}/>
                Pick Up
            </label>
                <br />
            <label htmlFor="">
                <input type="radio" name="" id="" value="Delivery" 
                    checked={shipping === "Delivery"}
                    onChange={handleShippingChange}/>
                Delivery
            </label>
            <p>Shipping: {shipping}</p>
        </div>
    );
}