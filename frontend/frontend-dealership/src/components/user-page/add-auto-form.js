import axios from "axios";
import React, {useState, useRef} from "react";
import { Link, useNavigate } from "react-router-dom";

function AddAutoForm(){
    const navigate = useNavigate();

    const [model, setModel] = useState("");
    const [description, setDescription] = useState("");
    const [price, setPrice] = useState(null);
    const [doorCount, setDoorCount] = useState(null);
    const [seatCount, setSeatCount] = useState(null);
    const [yearOfCreation, setYearOfCreation] = useState("");
    const [length, setLength] = useState(null);
    const [width, setWidth] = useState(null);
    const [height, setHeight] = useState(null);
    const [clearance, setClearence] = useState(null);
    const [trunkVolume, setTrunkVolume] = useState(null);
    const [carBrandName, setCarBrandName] = useState("");
    const [maxSpeed, setMaxSpeed] = useState("");
    const [fuelUsage, setFuelUsage] = useState("");
    const [bodyTypeName, setBodyTypeName] = useState("");
    const [gearboxName, setGearboxName] = useState("");
    const [gearboxModel, setGearboxModel] = useState("");
    const [stages, setStages] = useState(null);
    const [drive, setDrive] = useState("");
    const [gearboxType, setGearboxType] = useState("");
    const [engineName, setEngineName] = useState("");
    const [engineCapacity, setEngineCapacity] = useState(null);
    const [power, setPower] = useState("");
    const [numberOfCylinders, setNumberOfCylinders] = useState(null);
    const [engineType, setEngineType] = useState("");
    const [fuelType, setFuelType] = useState("");
    const [millage, setMillage] = useState(null);

    const fileInputRef = useRef(null);
    const [selectedFiles, setSelectedFiles] = useState([]);

    const handleFileUpload = () => {
        const files = fileInputRef.current.files;
        const selectedFilesArray = Array.from(files);
        setSelectedFiles(selectedFilesArray);
    };
    const handleDelImage = (index) => {
        const updatedFiles = [...selectedFiles];
        updatedFiles.splice(index, 1);
        setSelectedFiles(updatedFiles);
    };

    const data = {
        model,
        description,
        price,
        doorCount,
        seatCount,
        yearOfCreation,
        length,
        width,            
        height,
        clearance,
        trunkVolume,
        carBrandName,
        maxSpeed,
        fuelUsage,
        bodyTypeName,
        gearboxName,
        gearboxModel,
        stages,
        drive,
        gearboxType,
        engineName,
        engineCapacity,
        power,
        numberOfCylinders,
        engineType,
        fuelType,
        millage,
    };

    const formData = new FormData();
    const token = sessionStorage.getItem("token")

    const handleSubmit = async (e) => {
        e.preventDefault();
        for (let i = 0; i < selectedFiles.length; i++) {
            formData.append('files', selectedFiles[i]);
        }
        formData.append("data", new Blob([JSON.stringify(data)], { type: 'application/json' }));
        
        axios.post("http://localhost:8080/admin/car/new", formData, {
            headers: {
              'Content-Type': 'multipart/form-data',
              Authorization: `Bearer ${token}`
            },
        }).then((response) => {
            navigate(`${response.data.car.id}`)
            console.log(response);
        }).catch(err => {
            alert("Щось пішло не так при створенні нової машини.")
        })
    }

    return(
        <>
            <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div className="cs-user-section-title">
                    <h4>Додати автомобіль</h4>
                </div>
            </div>
            <form className="user-post-vehicles" onSubmit={handleSubmit}>
                <div className="cs-field-holder">
                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h6>Інформація про автомобіль</h6>
                    </div>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-seprator"></div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Модель автомобіля</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={model} onChange={(e) => setModel(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Марка</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={carBrandName} onChange={(e) => setCarBrandName(e.target.value)}/>
                        </div>
                    </div>
                </div>
                
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Рік випуску</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={yearOfCreation} onChange={(e) => setYearOfCreation(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Пробіг (км)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={millage} onChange={(e) => setMillage(e.target.value)}/>
                        </div>
                    </div>
                </div>

                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Споживання палива (л/км)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={fuelUsage} onChange={(e) => setFuelUsage(e.target.value)}/>
                        </div>
                    </div>
                </div>

                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Максимальна швидкість (км/год)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={maxSpeed} onChange={(e) => setMaxSpeed(e.target.value)}/>
                        </div>
                    </div>
                </div>

                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Ціна ($)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={price} onChange={(e) => setPrice(e.target.value)}/>
                        </div>
                    </div>
                </div>


                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Опис</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <textarea value={description} onChange={(e) => setDescription(e.target.value)}></textarea>
                        </div>
                    </div>
                </div>


                <div className="cs-field-holder">
                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h6>Завантаження фото</h6>
                    </div>
                </div>
                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-seprator"></div>
                </div>

                <div className="cs-field-holder">
                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div className="cs-upload-img">
                            <ul>
                                {selectedFiles.map((file, index) => (
                                    <li key={index}>
                                        <Link onClick={() => handleDelImage(index)} ><img src={URL.createObjectURL(file)} alt="" style={{maxWidth:"150px", maxHeight:"150px"}}/></Link>
                                    </li>
                                ))}
                            </ul>
                            <p>Фотографії повинні бути в форматі "jpeg, jpg, png, gif".</p>
                            <p>Ви можете обрати і завантажити декілька фотографій.</p>
                            <div className="cs-browse-holder"><span className="file-input btn-file"> Завантажити фото
                                <input type="file" multiple ref={fileInputRef} onChange={handleFileUpload}/>
                                </span> </div>
                        </div>
                    </div>
                </div>

                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-seprator"></div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h6><i className="cs-color icon-engine"></i>Двигун</h6>
                    </div>
                </div> 

                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Назва двигуна</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={engineName} onChange={(e) => setEngineName(e.target.value)}/>
                        </div>
                    </div>
                </div>
                
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Тип двигуна</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <select data-placeholder="Select Make" tabindex="1" className="chosen-select" 
                                    value={engineType} onChange={(e) => setEngineType(e.target.value)}
                            >
                                <option disabled selected value="">Оберіть тип двигуна</option>
                                <option value="Дизельний">Дизельний</option>
                                <option value="Бензиновий">Бензиновий</option>
                                <option value="Газовий">Газовий</option>
                                <option value="Електричний">Електричний</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Тип пального</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <select data-placeholder="Select Make" tabindex="1" className="chosen-select"
                                    value={fuelType} onChange={(e) => setFuelType(e.target.value)}
                            >
                                <option disabled selected value="">Оберіть тип пального</option>
                                <option value="Дизель">Дизель</option>
                                <option value="Бензин">Бензин</option>
                                <option value="Газ">Газ</option>
                                <option value="Електрика">Електрика</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Об'єм двигуна (л)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={engineCapacity} onChange={(e) => setEngineCapacity(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Потужність (к.с.)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={power} onChange={(e) => setPower(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Кількість циліндрів</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={numberOfCylinders} onChange={(e) => setNumberOfCylinders(e.target.value)}/>
                        </div>
                    </div>
                </div>
                

                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-seprator"></div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h6><i className="cs-color icon-vehicle92"></i>Коробка передач</h6>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Модель</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={gearboxModel} onChange={(e) => setGearboxModel(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Назва</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={gearboxName} onChange={(e) => setGearboxName(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Тип коробки передач</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <select data-placeholder="Select Make" tabindex="1" className="chosen-select"
                                    value={gearboxType} onChange={(e) => setGearboxType(e.target.value)}
                            >
                                <option disabled selected value="">Оберіть тип</option>
                                <option value="Автомат">Автомат</option>
                                <option value="Механіка">Механіка</option>
                                <option value="Роботизована">Роботизована</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Привід</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <select data-placeholder="Select Make" tabindex="1" className="chosen-select"
                                    value={drive} onChange={(e) => setDrive(e.target.value)}
                            >
                                <option disabled selected value="">Оберіть привід</option>
                                <option value="передній">Передній</option>
                                <option value="задній">Задній</option>
                                <option value="повний">Повний</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Кількість ступеней</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={stages} onChange={(e) => setStages(e.target.value)}/>
                        </div>
                    </div>
                </div>


                <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                    <div className="cs-seprator"></div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <h6><i className="cs-color icon-vehicle92"></i>Кузов і габарити</h6>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Тип кузову</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={bodyTypeName} onChange={(e) => setBodyTypeName(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Кількість дверей</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={doorCount} onChange={(e) => setDoorCount(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Кількість сидінь</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={seatCount} onChange={(e) => setSeatCount(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Об'єм багажника (л)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={trunkVolume} onChange={(e) => setTrunkVolume(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Довжина (мм)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={length} onChange={(e) => setLength(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Ширина (мм)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={width} onChange={(e) => setWidth(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Висота (мм)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={height} onChange={(e) => setHeight(e.target.value)}/>
                        </div>
                    </div>
                </div>
                <div className="cs-field-holder">
                    <div className="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                        <label>Кліренс (мм)</label>
                    </div>
                    <div className="col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div className="cs-field">
                            <input type="text" value={clearance} onChange={(e) => setClearence(e.target.value)}/>
                        </div>
                    </div>
                </div>

                
                <div className="cs-field-holder">
                    <div className="col-lg-4 col-md-4 col-sm-12 col-md-12">
                        <div className="cs-field">
                            <div className="cs-btn-submit">
                                <input type="submit" value="Зберегти і продовжити" />
                            </div>
                        </div>
                    </div>
                </div>
            </form>
        </>
    )
}

export default AddAutoForm;