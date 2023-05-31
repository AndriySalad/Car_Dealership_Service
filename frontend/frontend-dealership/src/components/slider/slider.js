import React, { useRef, useEffect, useState } from 'react';
import Slider from 'react-slick';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

const Slider1 = ({ images, id, status }) => {
  const sliderRef = useRef();
  const navigate = useNavigate();
  const [order, setOrder] = useState(null);
  useEffect(() => {
    const sliderElement = sliderRef.current;
    if (sliderElement) {
      sliderElement.slickGoTo(0);
    }
  }, []);

  const settings = {
    accessibility: true,
    dots: true,
    slidesToShow: 3,
    slidesToScroll: 1,
    prevArrow: <button type="button" className="slick-prev" aria-label="previous">Previous</button>,
    nextArrow: <button type="button" className="slick-next" aria-label="next">Next</button>,
    responsive: [
      {
        breakpoint: 768,
        settings: {
          slidesToShow: 1,
        },
      },
    ],
  };

  const token = sessionStorage.getItem("token");

  const handleOrder = async (e) => {
    e.preventDefault()
    const confirmation = window.confirm("Ви впевнені, що хочете зробити замовлення?")
    if(confirmation){
      if (token){
        await axios.post(`http://localhost:8080/cars/${id}/order`, null, {
              headers: {
                  Authorization: `Bearer ${token}`
              }
          }).then((response) => {
              console.log(response)
              setOrder(response.data)
          }).catch(error => {
            alert("Не вдалось зробити замовлення!")
            console.log(error)
          })
      }
      else{
        navigate("/login")
      }
    }
  }

  useEffect(() => {
    if (order) {
      alert(`Замовлення ${order.id} Успішно зроблено!`);
      navigate("/profile/order-list");
    }
  }, [order]);

  return (
    <div className="cs-banner loader">
      <Slider {...settings} ref={sliderRef}>
        {images.map((img) => (
          <div key={img.id}>
            <div className="cs-media">
              <figure><img src={img.linkFile} alt="" style={{ width: '100%', height: 'auto', marginBottom: "20px" }} /></figure>
            </div>
          </div>
        ))}
      </Slider>
      <div className="container">
        <div className="row">
          <div className="col-lg-6 col-md-6 col-sm-12 col-xs-12 pull-right">
            <div className="cs-button-style">
              {status === "AVAILABLE" ? <Link className="btn-shortlist" onClick={handleOrder}>Зробити замовлення</Link> : <h2>Продано!</h2>}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Slider1;
