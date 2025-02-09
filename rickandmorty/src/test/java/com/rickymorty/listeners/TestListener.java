package com.rickymorty.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("  🗣️ Iniciando prueba: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("  ✅ Prueba exitosa: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("  ❌ Test fallido: " + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn("  ⚠️ Prueba omitida: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("🗿 Iniciando suite de pruebas: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("🏁 Finalizando suite de pruebas: " + context.getName());
    }
}

