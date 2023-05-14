
function SearchPanel() {
    return (
        <div className="car-baner">
        <div className="search-bar">
          <div className="header-wrapper">
            <h3>Панель пошуку</h3>
          </div>
          <div className="search-bar-inputs-wrapper">
            <div className="search-bar-inputs">
              <ul>
                <li className="letter-input">
                  <select >
                    <option disabled="disabled" selected="selected">Марка:</option>
                    <option>Пункт 1</option>
                    <option>Пункт 2</option>
                  </select>
                </li>
                <li className="numeric-input">
                  <select >
                    <option disabled="disabled" selected="selected">Рік від:</option>
                    <option>Пункт 1</option>
                    <option>Пункт 2</option>
                  </select>
                </li>
                <li className="numeric-input">
                  <select >
                    <option disabled="disabled" selected="selected">Рік до:</option>
                    <option>Пункт 1</option>
                    <option>Пункт 2</option>
                  </select>
                </li>
                <li className="numeric-input">
                  <select >
                    <option disabled="disabled" selected="selected">Ціна від:</option>
                    <option>Пункт 1</option>
                    <option>Пункт 2</option>
                  </select>
                </li>
                <li className="numeric-input">
                  <select >
                    <option disabled="disabled" selected="selected">Ціна до:</option>
                    <option>Пункт 1</option>
                    <option>Пункт 2</option>
                  </select>
                </li>
                <li className="letter-input">
                  <select >
                    <option disabled="disabled" selected="selected">Коробка передач</option>
                    <option>Пункт 1</option>
                    <option>Пункт 2</option>
                  </select>
                </li>
                <li className="letter-input">
                  <select >
                    <option disabled="disabled" selected="selected">Тип палива</option>
                    <option>Пункт 1</option>
                    <option>Пункт 2</option>
                  </select>
                </li>
              </ul>
            </div>
            <a href="">Пошук</a>
          </div>
        </div>
      </div>
    );
}

export default SearchPanel;