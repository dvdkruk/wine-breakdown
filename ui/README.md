# Wine UI

## Description
Web UI to de display wine product details.

## Getting Started
### Dependencies
* Yarn 1.22.4

### Executing program
0. Make sure you have the wine API running at [http://localhost:8080](http://localhost:8080).
1. Run `yarn start`.
2. Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

### Executing build release
1. Run `yarn build`.
2. The production build will be in the `build` folder.

## Design
The project is structured by features. Every feature has a `Page` module that composes the feature and it dependencies. Communication with the back-end server is handle via service modules that are follow the pattern `fetch*.js`. More broken down UI elements are located in the `components` in each feature folder.

Possible improvements that can be made:
- Improve the styling of the UI to conform better with the figma mockups.
- Implement tests for ctricital components.
- CI/CD pipeline
- Apply atomic design for common components, so library can be build of reusable components.