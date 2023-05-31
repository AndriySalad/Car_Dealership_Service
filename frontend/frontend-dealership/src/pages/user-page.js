import React, {useEffect, useState} from "react";
import { Route, Routes } from "react-router-dom";
import AddAutoForm from "../components/user-page/add-auto-form";
import AdminCarList from "../components/user-page/admin-car-list";
import OrderList from "../components/user-page/order-list";
import UserBaner from "../components/user-page/user-baner";
import UserHeader from "../components/user-page/user-header";
import UserSettings from "../components/user-page/user-settings";
import axios from "axios";

function UserPage({carList}) {
    
    const token = sessionStorage.getItem('token')
    const [user, setUser] = useState(null);

    const getUser = async () => {
        await axios.get("http://localhost:8080/users/profile", {
            headers: {
                Authorization: `Bearer ${token}`
            }
        }).then((response) => {
            setUser(response.data)
        }).catch(error => console.log(error))
    }
    

    useEffect(() => {
        getUser()
    }, [])

    if(!user){
        return(
            <div><h1>Wait</h1></div>
        )
    }

    if(user.role === "ROLE_ADMIN"){
        return (
            <div className="wp-automobile">
                <div className="wrapper"> 
                    <div className="main-section">
                    <UserBaner/>
                        <div className="page-section">
                            <div className="container">
                                <div className="row">
                                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div className="cs-user-account-holder">
                                            <UserHeader user={user}/>
                                            <Routes>
                                                <Route path="admin-car-list" element={<AdminCarList carList={carList}/>}/>
                                                <Route path="order-list" element={<OrderList user = {user}/>}/>
                                                <Route path="settings" element={<UserSettings user={user}/>}/>
                                                <Route path="add-auto" element={<AddAutoForm/>}/>
                                            </Routes>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
    else {
        return (
            <div className="wp-automobile">
                <div className="wrapper"> 
                    <div className="main-section">
                    <UserBaner/>
                        <div className="page-section">
                            <div className="container">
                                <div className="row">
                                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div className="cs-user-account-holder">
                                            <UserHeader user={user}/>
                                            <Routes>
                                                <Route path="order-list" element={<OrderList user = {user}/>}/>
                                                <Route path="settings" element={<UserSettings/>}/>
                                            </Routes>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
    
}

export default UserPage;