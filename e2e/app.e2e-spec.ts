import { MySecondSpringMVCTutSpringHibernateTutPage } from './app.po';

describe('my-second-spring-mvctut-spring-hibernate-tut App', function() {
  let page: MySecondSpringMVCTutSpringHibernateTutPage;

  beforeEach(() => {
    page = new MySecondSpringMVCTutSpringHibernateTutPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
