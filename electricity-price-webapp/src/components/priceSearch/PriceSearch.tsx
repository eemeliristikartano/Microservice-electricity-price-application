import SearchedPrices from "../SearchedPrices/SearchedPrices";
import PriceSearchFormBox from "./PriceSearchFormBox";

const PriceSearch = () => {
    return (
        <div className="price-search-container" >
            <div >
                <PriceSearchFormBox />
            </div>
            <div >
                <SearchedPrices />
            </div>
        </div>

    );
}

export default PriceSearch;