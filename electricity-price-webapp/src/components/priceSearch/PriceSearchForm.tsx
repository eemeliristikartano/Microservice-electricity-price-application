import { useState } from "react";
import { addPrice } from '../../features/priceSearchSlice'
import { useAppDispatch } from "../../app/hooks";
import { fetchPrice } from "./actions";

const PriceSearchForm = () => {
    const [timeDate, setTimeDate] = useState({
        date: "",
        hour: 0
    });
    const dispatch = useAppDispatch();



    const handlePriceSearch = async (e: React.FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        dispatch(fetchPrice(timeDate));

        try {

        } catch (error) {

        }
    }



    return (
        <form className="price-search-form" onSubmit={(e) => handlePriceSearch(e)} >
            <label htmlFor="date">Date:</label>
            <input
                id="date"
                name="date"
                placeholder="YYYY-mm-dd"
                type="date"
                min="2021-01-01"
                value={timeDate.date}
                onChange={(e) => setTimeDate({ ...timeDate, date: e.target.value })}
            />
            <br />
            <label htmlFor="hour">Hour:</label>
            <input
                id="hour"
                name="hour"
                type="number"
                min={0} max={23}
                value={timeDate.hour}
                onChange={(e) => setTimeDate({ ...timeDate, hour: Number(e.target.value) })}
            />
            <br />
            <button>Search</button>
        </form>
    );
}

export default PriceSearchForm;