module Bossex {
    requires javafx.base;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    requires java.sql;
    requires java.net.http;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;

    opens BusinessGenie.app.Bossex.Views.Help;
    opens BusinessGenie.app.Bossex.Views.User;
    opens BusinessGenie.app.Bossex.Views.StockTransfers;
    opens BusinessGenie.app.Bossex.Views.StockAdjustments;
    opens BusinessGenie.app.Bossex.Views.Settings;
    opens BusinessGenie.app.Bossex.Views.Sell;
    opens BusinessGenie.app.Bossex.Views.Products;
    opens BusinessGenie.app.Bossex.Views.Purchases;
    opens BusinessGenie.app.Bossex.Views.Expenses;
    opens BusinessGenie.app.Bossex.Views.Contacts;
    opens BusinessGenie.app.Bossex.Views.Home;
    opens BusinessGenie.app.Bossex.Views.Reports;
    opens BusinessGenie.app.Bossex.Views.LoginPage;
    opens BusinessGenie.app.Bossex.Views.SettingsPage;
    opens BusinessGenie.app.Bossex.Views.MasterPage;
    opens BusinessGenie.app.Bossex.Resources;
    opens BusinessGenie.app.Bossex.Services;
    opens BusinessGenie.app.Bossex.Models;
    opens BusinessGenie.app.Bossex;

}