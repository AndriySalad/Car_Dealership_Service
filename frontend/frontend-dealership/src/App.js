import "./css/bootstrap-theme.css";
import "./css/bootstrap.css";
import "./css/style.css";
import "./css/chosen.css";
import "./css/color.css";
import "./css/cs-automobile-plugin.css";
import "./css/iconmoon.css";
import "./css/jquery.mCustomScrollbar.css";
import "./css/responsive.css";
import "./css/widget.css";
import "./css/woocommerce.css";

import React, {useEffect, useState} from "react";
import Header from "./components/header";
import Footer from "./components/footer";
import HomePage from "./pages/home";
import CarPage from "./pages/car-page";
import AboutUsPage from "./pages/about-us-page";
import CatalogPage from "./pages/catalog-page";
import UserPage from "./pages/user-page";
import {Route, Routes} from "react-router-dom";
import RegisterPage from "./components/signin-signup/sign-up";
import LoginPage from "./components/signin-signup/sign-in";
import axios from "axios";
import PrivateRoute from "./components/privateRoute.js";



const App = () => {

  const [carList, setCarList] = useState([]);
  const getCarList = async () => {
      await axios.get("http://localhost:8080/cars")
      .then((response) => {
          setCarList(response.data)
      }).catch(error => console.log(error))
  }

  
  return (
    <>
      <Header/>
        <Routes>
            <Route path="/" element={<HomePage getCarList={getCarList} carList={carList.slice(0, 8)}/>}/>
            <Route path="" element={<PrivateRoute />}>
              <Route path="/profile/*" element={<UserPage getCarList={getCarList} carList={carList}/>}/>
            </Route>
            <Route path="/about-us" element={<AboutUsPage/>}/>
            <Route path="/catalog" element={<CatalogPage getCarList={getCarList} carList={carList}/>}/>
            <Route path='/:id' element={<CarPage/>}/>
            <Route path="/login" element={<LoginPage />} />
            <Route path="/register" element={<RegisterPage/>}/>
            <Route path="*" element={<div>Oops!</div>}/>
        </Routes>
      <Footer/>
      
      
    </>
  );
};

export default App;
