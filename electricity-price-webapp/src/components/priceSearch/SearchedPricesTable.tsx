import { selectAllPrices } from '../../features/priceSearchSlice'
import { useAppSelector } from '../../app/hooks';

const SearchedPrices = () => {
    const prices = useAppSelector(selectAllPrices);

    const tableRows = prices.length > 0 && prices.map((price, index) =>
        <tr>
            <td>{index + 1}</td>
            <td>{price.price}</td>
            <td>{price.date}</td>
            <td>{price.hour}</td>
        </tr>);

    return (
        prices.length > 0 ?
            <>
                <h1>{prices.at(-1)!.price} € / kWh</h1>
                <div className="table-div">
                    <table>
                        <tr>
                            <th>#</th>
                            <th>€ / kWh</th>
                            <th>Date</th>
                            <th>Hour</th>
                        </tr>
                        {tableRows}
                    </table>
                </div>
            </>
            :
            <div></div>
    )


}

export default SearchedPrices;