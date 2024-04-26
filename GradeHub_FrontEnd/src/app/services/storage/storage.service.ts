import { Injectable } from '@angular/core';
import { isPlatformBrowser } from '@angular/common';
import { Injector } from '@angular/core';
import { PLATFORM_ID } from '@angular/core';

const USER = "c_user";
const TOKEN =  'c_token';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  private injector: Injector;

  constructor(injector: Injector) {
    this.injector = injector;
  }

  private getPlatformId(): any {
    return this.injector.get(PLATFORM_ID);
  }

  public saveUser(user: any): void {
    if (isPlatformBrowser(this.getPlatformId())) {
      window.localStorage.removeItem(USER);
      window.localStorage.setItem(USER, JSON.stringify(user));
    }
  }

  public saveToken(token: string): void {
    if (isPlatformBrowser(this.getPlatformId())) {
      window.localStorage.removeItem(TOKEN);
      window.localStorage.setItem(TOKEN, token);
    }
  }

  static getToken(): string | null {
    if (isPlatformBrowser(this.getPlatformId())) {
      return window.localStorage.getItem(TOKEN);
    }
    return null;
  }

  static getUser(): any {
    if (isPlatformBrowser(this.getPlatformId())) {
      return JSON.parse(localStorage.getItem(USER));
    }
    return null;
  }

  static hasToken(): boolean {
    return this.getToken() !== null;
  }

  static getUserRole(): string {
    const user = this.getUser();
    if (user == null) {
      return '';
    }
    return user.role;
  }

  static isAdminLoggedIn(): boolean {
    if (this.getToken() == null) {
      return false;
    }
    const role: string = this.getUserRole();
    return role === 'ADMIN';
  }

  static isStudentLoggedIn(): boolean {
    if (this.getToken() == null) {
      return false;
    }
    const role: string = this.getUserRole();
    return role === 'STUDENT';
  }

  static logout(): void {
    if (isPlatformBrowser(this.getPlatformId())) {
      window.localStorage.removeItem(TOKEN);
      window.localStorage.removeItem(USER);
    }
  }

  private static getPlatformId(): any {
    return (<any>StorageService).platformId;
  }
}