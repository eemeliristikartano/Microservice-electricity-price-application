import { addPrice, selectPrice } from '../../features/priceSearchSlice'
import { useAppDispatch, useAppSelector } from '../../app/hooks';

const SearchedPrices = () => {
    const prices = useAppSelector(selectPrice);
    const status = useAppSelector(state => state.priceSearch.prices);

    console.log(prices)

    return (
        <div>
            Jee
            { }
        </div>
    )


}

export default SearchedPrices;