/* jshint esversion: 6 */
/* jshint expr: true */

const jsdom = require('jsdom'),
	fs = require('fs'),
	expect = require('chai').expect,
	demo = require("../src/demo.js");

describe("Color Code Converter", function() {
	describe("RGB to Hex conversion", function() {
		it("converts the basic colors", function() {
			const redHex   = demo.rgbToHex(255, 0, 0);
			const greenHex = demo.rgbToHex(0, 255, 0);
			const blueHex  = demo.rgbToHex(0, 0, 255);

			expect(redHex).to.equal("ff0000");
			expect(greenHex).to.equal("00ff00");
			expect(blueHex).to.equal("0000ff");
		});
	});

	describe("Hex to RGB conversion", function() {
		it("converts the basic colors", function() {
			const red   = demo.hexToRgb("ff0000");
			const green = demo.hexToRgb("00ff00");
			const blue  = demo.hexToRgb("0000ff");

			expect(red).to.deep.equal([255, 0, 0]);
			expect(green).to.deep.equal([0, 255, 0]);
			expect(blue).to.deep.equal([0, 0, 255]);
		});
	});
});

describe("pow", function() {
	it("возводит в n-ю степень", function() {
		const result1 = demo.pow(2, 3);
		expect(result1).to.equal(8);

		const result2 = demo.pow(-3, 5);
		expect(result2).to.equal(-243);
	});
});