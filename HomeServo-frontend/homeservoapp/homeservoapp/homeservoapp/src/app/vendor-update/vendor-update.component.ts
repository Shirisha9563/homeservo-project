import { Component, OnInit } from '@angular/core';
import { VendorService } from '../vendor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendor-update',
  templateUrl: './vendor-update.component.html',
  styleUrls: ['./vendor-update.component.css']
})
export class VendorUpdateComponent implements OnInit {
  name: string;
  email: string;
  phoneNumber: string;
  password: string;
  role: string;
  costPerDay : number;
  vendorId: number;
  vendorDetails: any;

  constructor(private vendorservice : VendorService, private router : Router ) {
    this.name = '';
    this.email = '';
    this.password = '';
    this.phoneNumber = '';
    this.role = '';
    this.costPerDay=0;
    this.vendorId = 1;
    this.vendorDetails; // Set the appropriate customer ID
  }

  ngOnInit() {
    this.getVendorDetails();
  }

  getVendorDetails() {
    this.vendorservice.getVendorDetails(this.vendorId).subscribe(
      (vendorData) => {
        this.vendorDetails = vendorData;
      },
      (error) => {
        console.error('Failed to fetch customer details', error);
      }
    );
  }

  onSubmit() {
    // Prepare the data to update
    const updatedData = {
      id: this.vendorId,
      name: this.name,
      email: this.email,
      password: this.password,
      phoneNumber: this.phoneNumber,
      role: this.role,
      costPerDay: this.costPerDay,
    };

    // Call the service to update customer details
    this.vendorservice.updateVendorDetails( updatedData).subscribe(
      // (response) => {
      //   console.log('Customer details updated successfully');
      // },
      // (error) => {
      //   console.error('Failed to update customer details', error);
      // }

      {next: response => {
        // this.customer=response.data
        console.log('Data updated successfully')
      },
         
         error : error =>{console.log('Customer details updated successfully' )
         this.router.navigate(['\vendor-home'])
        //  this.customer = error.error.data
        }
      }
    );
    
  }
}



