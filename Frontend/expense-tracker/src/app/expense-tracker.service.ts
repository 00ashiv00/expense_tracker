import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categories } from './Models/categories';

import { Expenses } from './Models/expenses';

@Injectable({
  providedIn: 'root'
})
export class ExpenseTrackerService {
  
  constructor(private http:HttpClient) { }
  
  baseGetExpenseUrl="http://localhost:8080/expenses/all";
  baseAddExpenseUrl="http://localhost:8080/expenses/addExpense";
  baseGetCategoriesUrl="http://localhost:8080/categories/all";
  
  getAllExpenses():Observable<Expenses[]> {
    return this.http.get<Expenses[]>(`${this.baseGetExpenseUrl}`)
  }
  
  
  addExpense(expenseName: string, amount: number, catId: number):Observable<Expenses> {
    return this.http.post<Expenses>(`${this.baseAddExpenseUrl}/${catId}/${expenseName}`,amount);
  }
  
  getCategories():Observable<Categories[]> {
    return this.http.get<Categories[]>(`${this.baseGetCategoriesUrl}`);
    
  }

}
