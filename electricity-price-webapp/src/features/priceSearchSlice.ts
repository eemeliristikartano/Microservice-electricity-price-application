import { PayloadAction, createSlice } from "@reduxjs/toolkit";
import { RootState } from "../app/store";

interface PriceSearchState {
    prices: Price[]
}

interface Price {
    price: number
}

const initialState: PriceSearchState = {
    prices: []
}

export const priceSearchSlice = createSlice({
    name: "priceSearch",
    initialState,
    reducers: {
        addPrice: (state, action: PayloadAction<Price>) => {
            state.prices = state.prices.concat(action.payload)
        }
    }

});

export const { addPrice } = priceSearchSlice.actions;

export const selectPrice = (state: RootState) => state.priceSearch.prices;

export default priceSearchSlice.reducer;