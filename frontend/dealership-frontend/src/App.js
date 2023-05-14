import Header from "./components/header";
import SearchPanel from "./components/SearchPanel";
import CarCatalog from "./components/car-catalog";
import AboutUsSlider from "./components/slider";
import Footer from "./components/footer";


function App() {
  return (
    <div className="App">
      <Header/>
      <SearchPanel/>
      <div className="product-range">
        <div className="header-wrapper">
          <h3>Асортимент</h3>
        </div>
      </div>
      <CarCatalog/>
      <div className="button-show-more">
        <a className="show-more" href="">Показати всі</a>
      </div>
      <div className="dash"></div>
      <div className="about-header-wrapper">
        <div className="header-wrapper">
          <h3>Про нас</h3>
        </div>
      </div>
      <script src="/scripts/main.js"></script>
      <AboutUsSlider/>
      <Footer/>
    </div>
  );
}

export default App;
