import { Time } from "@angular/common";
import { Company } from "./Company";
import { StockExchange } from "./StockExchange";

export interface StockPrice{
    company: Company;
    stockExchange: StockExchange;
    currentPrice:Number;
    date: Date;
    time:Time;
}