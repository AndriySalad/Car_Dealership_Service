import React from 'react';
import Filter from './filter';
import PriceFilter from './price-filter';
import YearFilter from './year-filter';

const Sidebar = () => {

    const gearboxes = [
        {
            id: 0,
            title: "Передній привід"
        }
    ];

    const fuelTypes = [
        {
            id: 0,
            title: "Бензин"
        }
    ];

    const carBrands = [
        {
            id: 0,
            title: "BMW"
        },
        {
            id: 1,
            title: "BMW"
        },
        {
            id: 2,
            title: "BMW"
        },
        {
            id: 3,
            title: "BMW"
        }
    ]

    return (
        <aside className="section-sidebar col-lg-3 col-md-3 col-sm-12 col-xs-12">
        <div className="cs-listing-filters">
            <div className="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                <Filter title="Марка" children={carBrands}/>
                <Filter title="Тип коробки передач" children={gearboxes}/>
                <Filter title="Тип пального" children={fuelTypes}/>
                <PriceFilter />
                <YearFilter />
            </div>
        </div>
        </aside>
    );
};

export default Sidebar;
