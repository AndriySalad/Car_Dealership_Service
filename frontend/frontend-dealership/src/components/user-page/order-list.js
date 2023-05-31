import React, {useEffect, useState} from "react";
import OrderItem from "./order-item";
import axios from "axios";


function OrderList({user}){
    const token = sessionStorage.getItem("token");
    const [allOrders, setAllOrders] = useState([]);
    const getOrderList = async () => {
        if (user.role === "ROLE_USER"){
            await axios.get("http://localhost:8080/users/profile/order", {
                headers: {
                    Authorization: `Bearer ${token}`
                },
                withCredentials: true
            }).then((response) => {
                setAllOrders(response.data)
            }).catch(error => console.log(error))
        }
        else{
            await axios.get("http://localhost:8080/admin/orders", {
            headers: {
                Authorization: `Bearer ${token}`
            }
        }).then((response) => {
            setAllOrders(response.data)
        }).catch(error => console.log(error))
        }
    }

    useEffect(() => {
        getOrderList();
    }, [])

    if (!allOrders){
        return(<div><h1>wait</h1></div>)
    }

    return(
        <ul className="cs-shortlisted-car">
            {allOrders.map(order => (
                <OrderItem order={order}/>  
            ))}                
        </ul>
    )
}

export default OrderList;