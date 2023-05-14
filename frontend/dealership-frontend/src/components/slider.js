import React, { useState } from 'react';
import cars from "../img/cars.jpg"
import team from "../img/team.jpg"
import feedback from "../img/stock-photo-handsome-man-showing-thumb-gesture.jpg"
import deallership from "../img/deallership.jpg"

const Slider = () => {
  const [currentSlide, setCurrentSlide] = useState(0);

  const slides = [
    {
      title: "Наша історія",
      description: "Наш автосалон був заснований у 2005 році з метою надання високоякісних послуг на ринку автомобілів. Наша місія - забезпечити наших клієнтів відмінним сервісом та роботою з кожним клієнтом в особливий спосіб. Наші цінності - це професійна етика, відповідальність перед клієнтом та швидке реагування на потреби клієнтів.",
      image: deallership
    },
    {
      title: "Асортимент",
      description: "Наш автосалон пропонує широкий асортимент нових та вживаних автомобілів від провідних виробників. Ми також забезпечуємо післяпродажне обслуговування та ремонт, а також пропонуємо запчастини та аксесуари. Наші послуги відрізняються від інших на ринку завдяки нашій прив'язаності до високої якості та надійності.",
      image: cars
    },
    {
      title: "Наша команда",
      description: "Наша команда складається з професіоналів, які мають багаторічний досвід у сфері автомобілів та розуміють, як важливо забезпечити клієнтам найкращий сервіс. Наш підхід базується на особистій увазі до кожного клієнта та забезпеченні індивідуального підходу до кожного з них.",
      image: team
    },
    {
      title: "Про відгуки",
      description: "Ми пишаємось тим, що отримуємо багато позитивних відгуків від наших клієнтів, які підкреслюють якість наших послуг та наші здібності до розв'язання складних проблем. Ми завжди раді допомогти нашим клієнтам та забезпечити їм найкращий досвід покупки автомобіля.",
      image: feedback
    }
  ];

  const prevSlide = () => {
    const index = currentSlide === 0 ? slides.length - 1 : currentSlide - 1;
    setCurrentSlide(index);
  };

  const nextSlide = () => {
    const index = currentSlide === slides.length - 1 ? 0 : currentSlide + 1;
    setCurrentSlide(index);
  };

  return (
    <div className="slider">
      <div className="slides">
        {slides.map((slide, index) => (
          <div className={index === currentSlide ? "slide active-slide" : "slide"} key={index}>
            <div className="slide-content">
              <h2>{slide.title}</h2>
              <p>{slide.description}</p>
            </div>
            <div className="slide-image">
              <img src={slide.image} alt={`Slide ${index + 1}`} />
            </div>
          </div>
        ))}
      </div>
      <div className="navigation">
        <button className="prev" onClick={prevSlide}> Назад </button>
        <button className="next" onClick={nextSlide}> Вперед </button>
      </div>
    </div>
  );
};

export default Slider;