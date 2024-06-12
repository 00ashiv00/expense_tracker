import { Component } from '@angular/core';
import { ExpenseTrackerService } from './expense-tracker.service';
import { Categories } from './Models/categories';
import { Expenses } from './Models/expenses';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'expense-tracker';
  expenseName: string='';
  amount:number=null;
  catId:number=null;
  add:boolean=false;
  
  constructor(private service:ExpenseTrackerService){}
  
  expenses:Expenses[];
  categories:Categories[];
  
  ngOnInit(){
    this.service.getAllExpenses().subscribe((data:Expenses[])=>{
      this.expenses=data;
      console.log(data);
    })
    this.service.getCategories().subscribe((data:Categories[])=>{
      this.categories=data;
      console.log(data);
    })
  }
  
  toggleAdd() {
  if(this.add===false){
    this.add=true;
  }
  else{
    this.add=false;
  }
  }

  addExpense() {
    this.service.addExpense(this.expenseName,this.amount,this.catId).subscribe((data:any)=>{
      console.log(data);
      setTimeout(() => {
        window.location.reload();
      }, 1000);
    })
  }

}

