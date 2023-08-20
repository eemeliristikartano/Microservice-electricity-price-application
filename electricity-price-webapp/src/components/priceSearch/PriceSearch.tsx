import SearchedPrices from "./SearchedPricesTable";
import PriceSearchFormBox from "./PriceSearchFormBox";

const PriceSearch = () => {
    return (
        <div className="price-search-container" >
            <div >
                <PriceSearchFormBox />
            </div>
            <div style={{ display: 'flex', flexDirection: 'column' }}>
                <SearchedPrices />
            </div>
        </div>

    );
}

export default PriceSearch;