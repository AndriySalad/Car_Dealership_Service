import React from "react";


const sectionStyles = {
  pageSection: {
    marginTop: "70px",
    marginBottom: "70px"
  },
  sectionTitle: {
    textAlign: "center",
    color: "#333333",
    marginBottom: "45px",
  },
  services: {
    marginBottom: "30px",
  },
  media: {
    fontSize: "40px",
  },
};

const WhyChooseUsSection = () => {
  return (
    <div className="page-section" style={sectionStyles.pageSection}>
      <div className="container">
        <div className="row">
          
          <div className="col-lg-4 col-md-4 col-sm-6 col-xs-12">
            <div className="cs-services" style={sectionStyles.services}>
              <div className="cs-media">
                <i className="icon-car230 cs-color" style={sectionStyles.media}></i>
              </div>
              <div className="cs-text">
                <h6>Завжди нова інформація</h6>
                <p>Наш сайт гарантує виключно нову інформацію про автомобілі, які у нас представлені.</p>
              </div>
            </div>
          </div>
          <div className="col-lg-4 col-md-4 col-sm-6 col-xs-12">
            <div className="cs-services" style={sectionStyles.services}>
              <div className="cs-media">
                <i className="icon-car36 cs-color" style={sectionStyles.media}></i>
              </div>
              <div className="cs-text">
                <h6>Швидка купівля авто</h6>
                <p>Тільки у нас ви зможете купити нове авто буквально за одним натисканням, після чого з вами зв'яжеться наш менеджер для уточнення деталей.</p>
              </div>
            </div>
          </div>
          <div className="col-lg-4 col-md-4 col-sm-6 col-xs-12">
            <div className="cs-services" style={sectionStyles.services}>
              <div className="cs-media">
                <i className="icon-transport177 cs-color" style={sectionStyles.media}></i>
              </div>
              <div className="cs-text">
                <h6>Дружня команда</h6>
                <p>У нас дружня команда спеціалістів, які швидко обробляють всі замовлення</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default WhyChooseUsSection;
